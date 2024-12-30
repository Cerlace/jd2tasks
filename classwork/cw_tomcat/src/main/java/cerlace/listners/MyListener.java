package cerlace.listners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyListener implements HttpSessionAttributeListener {

    private String counterAttr = "counter";
    private String urlAttr = "URL";

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String currentAttributeName = event.getName();
        if (currentAttributeName.equals(counterAttr)) {
            Integer currentValueInt = (Integer) event.getValue();
            System.out.println("в Session добавлен счетчик=" + currentValueInt);
        } else if (currentAttributeName.equals(urlAttr)) {
            StringBuffer currentValueStr = (StringBuffer) event.getValue();
            System.out.println("в Session добавлен URL=" + currentValueStr);
        } else System.out.println("добавлен новый атрибут");
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        String currentAttributeName = event.getName();
        // в случае изменений, произведенных со счетчиком,
        // выводит соответствующее сообщение
        if (currentAttributeName.equals(counterAttr)) {
            Integer currentValueInt = (Integer) event.getValue();
            System.out.println("В Session заменен cчетчик=" + currentValueInt);
        }
    }

}
