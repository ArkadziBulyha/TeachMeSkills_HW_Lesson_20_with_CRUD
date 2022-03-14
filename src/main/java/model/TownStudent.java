package model;

public class TownStudent {

    private int id;
    private String nameTown;

    public TownStudent() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTown() {
        return nameTown;
    }

    public void setNameTown(String nameTown) {
        this.nameTown = nameTown;
    }


    @Override
    public String toString() {
        return "TownStudent" +
                "nameTown" + nameTown + "\t";
    }

}
