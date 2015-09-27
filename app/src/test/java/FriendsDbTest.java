import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.icaboalo.tabsdrawerretrofitwithbutternife.BuildConfig;
import com.icaboalo.tabsdrawerretrofitwithbutternife.sqlite.CoursesOpenHelper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * Created by icaboalo on 9/26/2015.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class FriendsDbTest {

    @Test
    public void testCreateDatabase(){
        Context context = RuntimeEnvironment.application;
        CoursesOpenHelper openHelper = new CoursesOpenHelper(context);

        SQLiteDatabase db = openHelper.getWritableDatabase();

        Assert.assertNotNull("La base de datos no se creo: (", db + ")");
        
    }
}
