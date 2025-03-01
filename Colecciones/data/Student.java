package data;
import java.time.LocalDate;

public class Student {
    private String id;
    private String names;
    private String lastNames;
    private LocalDate birthday;
    private double papa;
    private String zodiacSign;

    public Student(String id, String names, String lastNames, LocalDate birthday, double papa) {
        this.id = id;
        this.names = names;
        this.lastNames = lastNames;
        this.birthday = birthday;
        this.papa = papa;
        this.zodiacSign = zodiacCalculate(birthday);
    }

    private String zodiacCalculate(LocalDate birthday) {
        int day = birthday.getDayOfMonth();
        int month = birthday.getMonthValue();

        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Aries";
        if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Tauro";
        if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "Géminis";
        if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) return "Cáncer";
        if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "Leo";
        if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "Virgo";
        if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "Libra";
        if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) return "Escorpio";
        if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) return "Sagitario";
        if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "Capricornio";
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "Acuario";
        if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) return "Piscis";
        return "Desconocido";
    }

    public String getID() {return id;}
    public String getNames() {return names;}
    public String getLastNames() {return lastNames;}
    public LocalDate getBirthday() {return birthday;}
    public double getPAPA() {return papa;}
    public String getZodiacSign() {return zodiacSign;}
}

