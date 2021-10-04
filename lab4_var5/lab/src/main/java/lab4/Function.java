package lab4;

import java.util.regex.Pattern;

public interface Function {
    Pattern pat = Pattern.compile("/([-.0-9]+)");

    void solve(int x) 
        throws Exception;
}
