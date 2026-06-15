package companyApp.demo;

public class Company {

    private String company_name;
    private String company_city;
    private String MD_name;
    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public String getCompany_city() {
        return company_city;
    }
    public void setCompany_city(String company_city) {
        this.company_city = company_city;
    }
    public String getMD_name() {
        return MD_name;
    }
    public void setMD_name(String mD_name) {
        MD_name = mD_name;
    }
    public Company(String company_name, String company_city, String mD_name) {
        super();
        this.company_name = company_name;
        this.company_city = company_city;
        MD_name = mD_name;
    }

    public Company() {
        // Zero args constructor
    }
    public void show()
    {
        System.out.println("Company Details: "+company_name+ " Company Location:- "+company_city+" MD Name: "+MD_name);
    }
}
