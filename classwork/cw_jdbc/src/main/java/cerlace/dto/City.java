package cerlace.dto;

public class City {
    private int id;
    private String name;

    public City() {
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CityBuilder builder() {
        return new CityBuilder();
    }

    public static class CityBuilder {
        private int id;
        private String name;

        public CityBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public City build() {
            return new City(this.id, this.name);
        }
    }
}
