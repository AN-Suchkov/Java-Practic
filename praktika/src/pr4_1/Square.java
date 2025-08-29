package pr4_1;

class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public String getType() {
        return "Square";
    }

    @Override
    public String toString() {
        return super.toString().replace("Rectangle", "Square");
    }
}
