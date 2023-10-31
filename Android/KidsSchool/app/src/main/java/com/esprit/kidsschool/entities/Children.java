package com.esprit.kidsschool.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Habib on 26/11/2016.
 */

public class Children implements Parcelable {

    private String idParent,avancement,note,nom,photo;


    public String getIdParent() {
        return idParent;
    }

    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }

    public String getAvancement() {
        return avancement;
    }

    public void setAvancement(String avancement) {
        this.avancement = avancement;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Children(String idParent, String avancement, String note, String photo,String nom) {
        this.idParent = idParent;
        this.avancement = avancement;
        this.note = note;
        this.photo = photo;
        this.nom = nom;
    }

    public Children() {
    }

    @Override
    public String toString() {
        return "Children{" +
                ", idParent=" + idParent +
                ", avancement=" + avancement +
                ", note=" + note +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idParent);
        dest.writeString(avancement);
        dest.writeString(note);
        dest.writeString(photo);
        dest.writeString(nom);
    }

    protected Children(Parcel in) {
        idParent = in.readString();
        avancement = in.readString();
        note = in.readString();
        photo = in.readString();
        nom = in.readString();
    }

    public static final Creator<Children> CREATOR = new Creator<Children>() {
        @Override
        public Children createFromParcel(Parcel in) {
            return new Children(in);
        }

        @Override
        public Children[] newArray(int size) {
            return new Children[size];
        }
    };

}
