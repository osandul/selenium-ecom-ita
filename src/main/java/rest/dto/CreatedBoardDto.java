package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreatedBoardDto {
    private String id;
    private String name;
    private String desc;
    private Object descData;
    private boolean closed;
    private String idOrganization;
    private Object idEnterprise;
    private boolean pinned;
    private String url;
    private String shortUrl;
    private Prefs prefs;
    private LabelNames labelNames;
    private Limits limits;

    @Data
    @AllArgsConstructor
    public static class Prefs {
        private String permissionLevel;
        private boolean hideVotes;
        private String voting;
        private String comments;
        private String invitations;
        private boolean selfJoin;
        private boolean cardCovers;
        private boolean isTemplate;
        private String cardAging;
        private boolean calendarFeedEnabled;
        private boolean isPluginHeaderShortcutsEnabled;
        private List<Object> enabledPluginBoardButtons;
        private String background;
        private Object backgroundImage;
        private Object backgroundImageScaled;
        private boolean backgroundTile;
        private String backgroundBrightness;
        private String backgroundColor;
        private String backgroundBottomColor;
        private String backgroundTopColor;
        private boolean canBeprivate;
        private boolean canBeEnterprise;
        private boolean canBeOrg;
        private boolean canBePrivate;
        private boolean canInvite;
    }

    @Data
    @AllArgsConstructor
    public static class LabelNames {
        private String green;
        private String yellow;
        private String orange;
        private String red;
        private String purple;
        private String blue;
        private String sky;
        private String lime;
        private String pink;
        private String black;
    }

    @Data
    @AllArgsConstructor
    public static class Limits {
    }

}

