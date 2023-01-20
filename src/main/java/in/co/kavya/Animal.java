package in.co.kavya;

class Animal {

    public void canJump(){
        System.out.println("Animal can Jump");
    }

    public List<String> pdfToText(String pdfPath) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfPath));
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        List<String> lines = Arrays.asList(text.split("\\r?\\n"));
        return lines;
    }


    public boolean ldapAuthentication(String username, String password) throws NamingException {
        String ldapURL = "ldap://localhost:10389";
        String base = "dc=example,dc=com";
        String dn = "uid=" + username + ",ou=people," + base;
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapURL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, dn);
        env.put(Context.SECURITY_CREDENTIALS, password
    }
}