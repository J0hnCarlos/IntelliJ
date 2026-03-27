package donadoni.models;

public class Cinema {
    private Long id = null;
    private String location = null, name = null;

    public Cinema(String location, String name){
        this.location = location;
        this.name = name;
    }

    public Cinema(){
        this(null, null);
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return "Cinema ID: " + id +
                "\n Location: " + location;
    }
}
