package tek.tdd.api.models;

import java.util.List;

public class PlanCodesList {
    private List<PlanCodeResponse> responses;

    public PlanCodesList() {
    }

    public PlanCodesList(List<PlanCodeResponse> responses) {
        this.responses = responses;
    }

    public List<PlanCodeResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<PlanCodeResponse> responses) {
        this.responses = responses;
    }
}
