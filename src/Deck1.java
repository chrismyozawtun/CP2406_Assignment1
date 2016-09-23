import com.dd.plist.*;

import java.io.File;

import static com.dd.plist.PropertyListParser.parse;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;

/**
 * Created by Michael White, #12862610 on 22/09/16.
 */
public class Deck1 {
        File file = new File("MstCards_151021.plist");
        NSDictionary rootDict = (NSDictionary) parse(file);
        String name = rootDict.objectForKey("Name").toString();
        NSObject[] parameters = ((NSArray)rootDict.objectForKey("Parameters")).getArray();
        for(NSObject param: parameters) {
            if(param.getClass().equals(NSNumber.class)) {
                NSNumber num = (NSNumber)param;
                switch(num.type()) {
                    case NSNumber.BOOLEAN : {
                        boolean bool = num.boolValue();
                        //...
                        break;
                    }
                    case NSNumber.INTEGER : {
                        long l = num.longValue();
                        //or int i = num.intValue();
                        //...
                        break;
                    }
                    case NSNumber.REAL : {
                        double d = num.doubleValue();
                        //...
                        break;
                    }
                }
                // else...
            }
        System.out.printStackTrace();
        }
}
