public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);


        int N = in.readInt();
        double R = in.readDouble();

        return R;

    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);

        int N = in.readInt();
        double R = in.readDouble();
        Planet[] Ps = new Planet[N];

        for (int i = 0; i < N; ++i) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Ps[i] = new Planet(xP, yP, xV, yV, m,img);

        }
        return Ps;
    }
}
