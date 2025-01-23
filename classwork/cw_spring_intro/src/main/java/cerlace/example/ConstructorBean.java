package cerlace.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class ConstructorBean {

    private String name;

    private List<String> stringList;

    private Map<Long, String> map;

    public ConstructorBean(String name) {
        this.name = name;
    }
}
