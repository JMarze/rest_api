package utilitarios;

public class ApiConfiguracion {

    public static final String CREATE_PROJECT=GetPropiedades.getInstance().getHost()+"/api/projects.json";
    public static final String UPDATE_PROJECT=GetPropiedades.getInstance().getHost()+"/api/projects/%s.json";
    public static final String READ_PROJECT=GetPropiedades.getInstance().getHost()+"/api/projects/%s.json";
    public static final String DELETE_PROJECT=GetPropiedades.getInstance().getHost()+"/api/projects/%s.json";

    //public static final String AuthToken =GetPropiedades.getInstance().getHost()+"/api/authentication/%s.json";
    public static final String GET_TOKEN=GetPropiedades.getInstance().getHost()+"/api/authentication/token.json";
}
