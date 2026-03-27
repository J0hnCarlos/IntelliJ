package donadoni.models;

public class Ticket{
    private Long id = null;
    private String sessionDetail = null;
    private Integer numOfTicket = null;

    public Ticket(String sessionDetail, int numOfTicket){
        this.sessionDetail = sessionDetail;
        this.numOfTicket = numOfTicket;
    }

    public Ticket(){

    }

    public long getID(){
        return id;
    }

    public void setID(long id){
        this.id = id;
    }

    public String getSessionDetail(){
        return sessionDetail;
    }

    public void setSessionDetail(String sessionDetail){
        this.sessionDetail = sessionDetail;
    }

    public int getNumOfTicket(){
        return numOfTicket;
    }

    public void setNumOfTicket(int numOfTicket){
        this.numOfTicket = numOfTicket;
    }

    public String toString(){
        return "Movie{" +
                "id= " + id +
                "\n sessionDetails= " + sessionDetail +
                "\n numOfTickets= " + numOfTicket +
                "}";
    }
}