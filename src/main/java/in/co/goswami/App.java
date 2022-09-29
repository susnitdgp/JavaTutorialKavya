package in.co.goswami;


/**
 * Hello world!
 *
 */
public class App 
{

    final static String GRAPH_DEFAULT_SCOPE = "https://graph.microsoft.com/.default";
    private final static String CLIENT_ID = "518083cf-2c06-4a7d-8245-f08a6736e677";
    private final static String AUTHORITY = "https://login.microsoftonline.com/2c631f90-6a65-4bb3-a626-c0f6f5790a9a/";
    private final static String CLIENT_SECRET = "sy.8Q~6CoQuTkvYcrZfaT2gIyRwuxT9oMJdw4dfW";

    public static void main( String[] args )
    {
        System.out.println( "Hello World From Goswami" );
        System.out.println("Again Hello");

        Rahul rahul=new Rahul();
        rahul.canRun();
    }
    private static IAuthenticationResult acquireToken() throws Exception {

     // Load token cache from file and initialize token cache aspect. The token cache will have
     // dummy data, so the acquireTokenSilently call will fail.
     //TokenCacheAspect tokenCacheAspect = new TokenCacheAspect("sample_cache.json");

     IClientCredential credential = ClientCredentialFactory.createFromSecret(CLIENT_SECRET);
     ConfidentialClientApplication cca =
             ConfidentialClientApplication
                     .builder(CLIENT_ID, credential)
                     .authority(AUTHORITY)
                     .build();

     IAuthenticationResult result;
     try {
         SilentParameters silentParameters =
                 SilentParameters
                         .builder(SCOPE)
                         .build();

         // try to acquire token silently. This call will fail since the token cache does not
         // have a token for the application you are requesting an access token for
         result = cca.acquireTokenSilently(silentParameters).join();
     } catch (Exception ex) {
         if (ex.getCause() instanceof MsalException) {

             ClientCredentialParameters parameters =
                     ClientCredentialParameters
                             .builder(SCOPE)
                             .build();

             // Try to acquire a token. If successful, you should see
             // the token information printed out to console
             result = cca.acquireToken(parameters).join();
         } else {
             // Handle other exceptions accordingly
             throw ex;
         }
     }
     return result;
 }
}
