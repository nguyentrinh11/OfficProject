
package offic.htk.com.officproject.rest.response.ListOrganizations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListOrganizations {

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("results")
    @Expose
    private List<Organization> results = new ArrayList<Organization>();

    /**
     * @return The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * @param metadata The metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * @return The results
     */
    public List<Organization> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Organization> results) {
        this.results = results;
    }

}
