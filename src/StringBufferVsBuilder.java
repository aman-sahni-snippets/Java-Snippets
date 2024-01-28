public class StringBufferVsBuilder {
    public static void main(String[] args) {

        StringBuilder objStringBuilder = new StringBuilder();
        StringBuffer objStringBuffer = new StringBuffer();

        Thread t1 = new Thread(() ->
        {
            for(int i=0; i<1000; i++)
            {
                objStringBuilder.append("A");
                objStringBuffer.append("A");
            }
        });

        Thread t2 = new Thread(() ->
        {
            for(int i=0; i<1000; i++)
            {
                objStringBuilder.append("B");
                objStringBuffer.append("B");
            }
        });

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (Exception e) {

        };

        //StringBuilder is not thread safe, so it will not give exact length (2000)
        System.out.println("StringBuilder Length: "+objStringBuilder.toString().length());

        //StringBuffer is thread safe, so it will give exact length (2000)
        System.out.println("StringBuffer Length: "+objStringBuffer.toString().length());

















    }


}
