package choubanidev.ensit.com.tp3_ex2;


import android.os.Parcel;
import android.os.Parcelable;

public class Etudiant implements Parcelable {

    private int id;
    private String option;
    private String nom;
    private String email;
    private int abs;

    public Etudiant(int id,String nom, String email,String option, int abs) {
        this.id = id;
        this.option = option;
        this.nom = nom;
        this.email = email;
        this.abs = abs;
    }

    public Etudiant(String nom) {
        this.nom = nom;
    }

    public Etudiant(String nom, String email, String option, int abs) {

        this.option = option;
        this.nom = nom;
        this.email = email;
        this.abs = abs;
    }


    protected Etudiant(Parcel in) {
        id = in.readInt();
        option = in.readString();
        nom = in.readString();
        email = in.readString();
        abs = in.readInt();
    }


    public static final Creator<Etudiant> CREATOR = new
            Creator<Etudiant>() {
                @Override
                public Etudiant createFromParcel(Parcel in) {
                    return new Etudiant(in);
                }

                @Override
                public Etudiant[] newArray(int size) {
                    return new Etudiant[size];
                }
            };

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(option);
        dest.writeString(nom);
        dest.writeString(email);
        dest.writeInt(abs);
    }
}
