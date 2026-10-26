package demoqa.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestData {
    private String simpleAlertText;
    private String confirmAlertText;
    private String promptAlertText;
    private String confirmButtonChooseText;
    private int randomStringLength;
    private String nestedParentFrameText;
    private String nestedChildFrameText;
    private List<User> users;
}