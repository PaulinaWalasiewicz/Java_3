package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.HashMap;

@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig config) throws ServletException {
        context = config.getServletContext();
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HashMap myMap = (HashMap) context.getAttribute("MyMap");


        int value = 0;
        String myUrl = ((HttpServletRequest)request).getRequestURI();
        if(myMap.containsKey(myUrl)){
            value = (int) myMap.get(myUrl);
            myMap.put(myUrl,value+1);
        }else{
            myMap.put(myUrl,1);

        }
        context.setAttribute("MyMap",myMap);
        System.out.println(myUrl);
        chain.doFilter(request, response);
    }
}
