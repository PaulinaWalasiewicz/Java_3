package listeners;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.*;

@WebListener
public class MyListener implements ServletContextListener,ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    public MyListener() {
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String,Integer> map = new HashMap<>();
        ServletContext context = sce.getServletContext();
        context.setAttribute("MyMap",map);
        System.out.println("Map initialized");
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        HashMap map = (HashMap) context.getAttribute("MyMap");
        map.clear();
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeReplaced(event);
        ArrayList<Integer> list = new ArrayList<>();

        ServletContext context = event.getServletContext();
        HashMap map = (HashMap) context.getAttribute("MyMap");
        System.out.println("replaced");

        if(!isHashMapSorted(map)) {
            List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            };
            Collections.sort(entries, valueComparator);

            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> entry : entries) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            System.out.println(sortedMap);

            context.setAttribute("MyMap", sortedMap);
        }

    }
    public static boolean isHashMapSorted(HashMap<String, Integer> map) {
        Integer prevValue = null;
        for (Integer value : map.values()) {
            if (prevValue != null && value > prevValue) {
                System.out.println("List is not sorted");

                return false;
            }
            prevValue = value;
        }
        System.out.println("List is sorted");
        return true;
    }
}
