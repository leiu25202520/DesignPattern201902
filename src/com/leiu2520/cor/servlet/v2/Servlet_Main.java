package com.leiu2520.cor.servlet.v2;


import java.util.ArrayList;
import java.util.List;

public class Servlet_Main {
    public static void main(String[] args){
        Request request = new Request();
        request.str = "大家好:),<script>,欢迎访问 mashibing.com , 大家都是996";
        Response response = new Response();
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HTMLFilter()).add(new SensitiveFilter());
        chain.doFilter(request,response);
        System.out.println(request.str);
        System.out.println(response.str);
    }


}


interface Filter{
    boolean doFilter(Request request, Response response);
}

class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("<","[").replaceAll(">","]");
        response.str += "--HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("996","955");
        response.str += "--SensitiveFilter()";
        return true;
    }
}

class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {

        for(Filter f : filters){
            if(!f.doFilter(request,response)) return false;
            //f.doFilter(request,response);
        }

        return true;
    }
}

class Request{
    String str;
}

class Response {
    String str;
}
