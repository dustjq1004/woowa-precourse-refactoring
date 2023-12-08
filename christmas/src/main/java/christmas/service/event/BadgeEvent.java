package christmas.service.event;

public enum BadgeEvent {

    STAR("별", 5_000),
    REE("트리", 10_000),
    SANTA("산타", 20_000),
    NO_BADGE("없음", 0);

    private String name;
    private int amount;

    BadgeEvent(final String name, final int amount) {
        this.name = name;
        this.amount = amount;
    }

    public static BadgeEvent getEventBadgeIfPrice(final int price) {
        BadgeEvent selectedBadge = NO_BADGE;
        for (BadgeEvent badge : values()) {
            if (price >= badge.amount) {
                selectedBadge = badge;
            }
        }
        return selectedBadge;
    }

    public String getName() {
        return name;
    }
}
