package p05_10_2023;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class SwagLabsRetry implements IRetryAnalyzer {
 private int count=0;
 private  int maxRrtry=3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count< maxRrtry){
            count++;
            return true;
        }
        return false;
    }
}
