package com.my.innerclasses;

/**
 * @auther Summerday
 */
//Nesting a class within a scope
public class Parcel6 {
    private void internalTracking(boolean b){
        //meaning that it can only be used in scope
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String id){
                    this.id = id;
                }
                String getSlip(){
                    return this.id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String id = ts.getSlip();
            System.out.println(id);
        }
        //! false:TrackingSlip ts = new TrackingSlip("slip");
    }
    public void track(){
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();//slip
    }
}
