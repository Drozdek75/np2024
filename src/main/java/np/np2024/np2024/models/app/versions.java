package np.np2024.np2024.models.app;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class versions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long releaseDate;

    private String releaseName;

    public versions() {
    }

    public versions(long releaseDate, String releaseName) {
        this.releaseDate = releaseDate;
        this.releaseName = releaseName;
    }

    public Long getId() {
        return this.id;
    }

    public long getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseName() {
        return this.releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

}
