/**
 * Created with IntelliJ IDEA.
 * User: mosama
 * Date: 11/18/12
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpeedTest {

    public static void main(String args[]){
        byte[] blockIn = new byte[256 * 1024];

        long startTime = System.currentTimeMillis();
        int iterations=10000;
        for (int i = 0; i != iterations; i++) {
            MurmurHash.hash32(blockIn, 0, blockIn.length, 0);
        }
        long Time= System.currentTimeMillis()-startTime;
        System.out.println("Murmur hash speed: "+(1000.0*blockIn.length*iterations/(1e6*Time))+ " MB/Sec");

        startTime = System.currentTimeMillis();
        for (int i = 0; i != iterations; i++) {
            PerlHash.hash(0,blockIn,0,blockIn.length);
        }
        Time= System.currentTimeMillis()-startTime;
        System.out.println("Perl hash speed: "+(1000.0*blockIn.length*iterations/(1e6*Time))+ " MB/Sec");
    }
}
