//Gleb Syomichev
import java.lang.Math;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    
    //////////////////////////////////////////////////////////////////////////////////
    // ↓ Input Coordinates Below ↓ // Remember to Use Doubles //
    System.out.println(classify(-1.48,0.55, -0.94,-1.61, 0.05,-0.18, -2.47,-0.8));
    //////////////////////////////////////////////////////////////////////////////////
  }

  public class Global {
    public static Double PointOnex = 0.0;
    public static Double PointOney = 0.0;
    public static Double PointTwox = 0.0;
    public static Double PointTwoy = 0.0;
    public static Double PointThreex = 0.0;
    public static Double PointThreey = 0.0;
    public static Double PointFourx = 0.0;
    public static Double PointFoury = 0.0;
  }  
  
  public static String classify(Double x1, Double y1, Double x2, Double y2, Double x3, Double y3, Double x4, Double y4){
    double angle1 = (Math.toDegrees(Math.atan2(y1, x1)));
    double angle2 = (Math.toDegrees(Math.atan2(y2, x2)));
    double angle3 = (Math.toDegrees(Math.atan2(y3, x3)));
    double angle4 = (Math.toDegrees(Math.atan2(y4, x4)));

    if (angle1 < 0.0) {
      angle1 = Double.sum(angle1, 360);
    }
    if (angle2 < 0.0) {
      angle2 = Double.sum(angle2, 360);
    }
    if (angle3 < 0.0) {
      angle3 = Double.sum(angle3, 360);
    }
    if (angle4 < 0.0) {
      angle4 = Double.sum(angle4, 360);
    }
    Double[] angles = {angle1, angle2, angle3, angle4};
    Arrays.sort(angles);

    if (angles[0] == angle1){
      Global.PointOnex = x1;
      Global.PointOney = y1;
    }
    if (angles[0] == angle2){
      Global.PointOnex = x2;
      Global.PointOney = y2;
    }
    if (angles[0] == angle3){
      Global.PointOnex = x3;
      Global.PointOney = y3;
    }
    if (angles[0] == angle4){
      Global.PointOnex = x4;
      Global.PointOney = y4;
    }
    if (angles[1] == angle1){
      Global.PointTwox = x1;
      Global.PointTwoy = y1;
    }
    if (angles[1] == angle2){
      Global.PointTwox = x2;
      Global.PointTwoy = y2;
    }
    if (angles[1] == angle3){
      Global.PointTwox = x3;
      Global.PointTwoy = y3;
    }
    if (angles[1] == angle4){
      Global.PointTwox = x4;
      Global.PointTwoy = y4;
    }
    if (angles[2] == angle1){
      Global.PointThreex = x1;
      Global.PointThreey = y1;
    }
    if (angles[2] == angle2){
      Global.PointThreex = x2;
      Global.PointThreey = y2;
    }
    if (angles[2] == angle3){
      Global.PointThreex = x3;
      Global.PointThreey = y3;
    }
    if (angles[2] == angle4){
      Global.PointThreex = x4;
      Global.PointThreey = y4;
    }
    if (angles[3] == angle1){
      Global.PointFourx = x1;
      Global.PointFoury = y1;
    }
    if (angles[3] == angle2){
      Global.PointFourx = x2;
      Global.PointFoury = y2;
    }
    if (angles[3] == angle3){
      Global.PointFourx = x3;
      Global.PointFoury = y3;
    }
    if (angles[3] == angle4){
      Global.PointFourx = x4;
      Global.PointFoury = y4;
    }
    x1 = Global.PointOnex;
    y1 = Global.PointOney;
    x2 = Global.PointTwox;
    y2 = Global.PointTwoy;
    x3 = Global.PointThreex;
    y3 = Global.PointThreey;
    x4 = Global.PointFourx;
    y4 = Global.PointFoury;
    Double onetotwo = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    Double twotothree = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
    Double threetofour = Math.sqrt((x4-x3)*(x4-x3)+(y4-y3)*(y4-y3));
    Double fourtoone = Math.sqrt((x1-x4)*(x1-x4)+(y1-y4)*(y1-y4));
    Double largest = Math.max(Math.max(onetotwo, twotothree),Math.max(threetofour, fourtoone));
    Double len1 = onetotwo/largest;
    Double len2 = twotothree/largest;
    Double len3 = threetofour/largest;
    Double len4 = fourtoone/largest;
    Double[] lengths = {len1, len2, len3, len4};
    int i = 0;
    int far = 0;
    int close = 0;
    while (i<lengths.length){
      if (lengths[i] > 0.55){
        far += 1;
        //System.out.println(lengths[i]);
      }
      else if(lengths[i] < 0.55){
        close += 1;
        //System.out.println(lengths[i]);
      }
      i++;
    }

    if (far == 4 & close == 0){
      return("Cross System");
    }
    if (far == 2 & close == 2){
      return("Cusp System");
    }
    if (far == 3 & close == 1){
      return("Fold System");
    }
    return("Error");
  }
}