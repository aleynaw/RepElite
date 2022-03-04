package model;

//All categories for preset exercises
public enum Category {
    Quads {
        public String toString() {
            return "Quads";
        }
    },
    Glutes {
        public String toString() {
            return "Glutes";
        }
    }, Back {
        public String toString() {
            return "Back";
        }
    }, Shoulders {
        public String toString() {
            return "Shoulders";
        }
    }
}
