public class Screen implements ScreenSpec{
    public String resolution;
    public int refreshRate, responseTime;

    public Screen(String resolution, int refreshRate, int responseTime)
    {
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.responseTime = responseTime;
    }

    public String toString() {
        return "Screen: " + "\n" + "Resolution: " + resolution +
                "\n" + "Refresh Rate: " + refreshRate + "\n" +
                "Response Time: " + responseTime;
    }

    public String getResolution() {
        return resolution;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public int getResponseTime() {
        return responseTime;
    }
}
