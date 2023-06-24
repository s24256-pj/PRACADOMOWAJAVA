package currencynbp.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Indywidualny identyfikator waluty", type="Long",minimum = "1")
    private Long id;

    @Schema(description = "Skrócona nazwa waluty - kod tej waluty",type = "String",minimum = "3" ,maximum = "3")
    private String name;

    @Schema(description = "Obliczony średni kurs waluty z wybranych ilości dni",type = "double")
    private double averagerate;
    @Schema(description = "Ilość dni, z których został obliczony średni kurs wybranej waluty", type="int", minimum = "1",maximum = "31")
    private int days;

    @Schema(description = "Czas, w którym zostało wysłane zapytanie", type="LocalDateTime")
    private LocalDateTime time;

    public Currency(){

    }
    public Currency(Long id,int days,String name,double averagerate,LocalDateTime time){
        this.averagerate = averagerate;
        this.id = id;
        this.name = name;
        this.time = time;
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getAveragerate() {
        return averagerate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setAveragerate(double averagerate) {
        this.averagerate = averagerate;
    }
}
