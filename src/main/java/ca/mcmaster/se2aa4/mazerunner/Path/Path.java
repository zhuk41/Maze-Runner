package ca.mcmaster.se2aa4.mazerunner.Path;

public class Path {
    private String path ;
    public Path(){path ="";}
    public Path(String pathString){
        path = pathString;
    }
    public void printPath(){
        System.out.println( "** Path: "+path);
    }
    public void printFactorizedPath(){
        System.out.println( "** Factorized Path: "+"\""+factorize()+"\"");
    }
    public void addStep(char step){
        path+=step;
    }
    public int length(){
        return path.length();
    }
    public char stepAt(int index){
        return path.charAt(index);
    }
    private String factorize(){
        StringBuilder f = new StringBuilder();
        int count = 1;
        char step = path.charAt(0);
        for (int i = 1; i < path.length();i++){
            if (path.charAt(i)==step){
                count+=1;
            }
            else {
                if (1 < count) {
                    f.append(count);
                }
                f.append(step);
                f.append(' ');
                step = path.charAt(i);
                count = 1;
            }
        }
        if (1 < count) {
            f.append(count);
        }
        f.append(path.charAt(path.length()-1));
        return f.toString();
    }
    public Path unFactorize(){
        StringBuilder u = new StringBuilder();
        int num = -1;
        for (int i = 0; i < path.length();i++){
            if('0'<= path.charAt(i) && path.charAt(i) <='9'){
                if (num==-1){
                    num = i;
                }
            }
            else if (!(num==-1)) {
                int count = Integer.parseInt(path.substring(num,i));
                for (int j = 0; j < count; j++){
                    u.append(path.charAt(i));
                }
                num = -1;
            }
            else if (path.charAt(i) == 'F'||path.charAt(i) == 'L'||path.charAt(i) == 'R'){
                u.append(path.charAt(i));
            }
        }
        return new Path(u.toString());
    }

}

