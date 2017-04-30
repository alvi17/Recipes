package alvi17.eidrecipe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import alvi17.eidrecipe.adapters.CustomAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] recipes;
    Integer[] images={R.drawable.r1,R.drawable.r2,R.drawable.r3,R.drawable.r4,R.drawable.r5,R.drawable.r6,
            R.drawable.r7,R.drawable.r8,R.drawable.r9,R.drawable.r10,R.drawable.r11,R.drawable.r12,
            R.drawable.r13,R.drawable.r14,R.drawable.r15,R.drawable.r16,R.drawable.r17,R.drawable.r18,
            R.drawable.r19,R.drawable.r20,R.drawable.r21,R.drawable.r22,R.drawable.r23,R.drawable.r24,
            R.drawable.r25,R.drawable.r26,R.drawable.r27,R.drawable.r28,R.drawable.r29,R.drawable.r30,
            R.drawable.r31,R.drawable.r32,R.drawable.r33,R.drawable.r34,R.drawable.r35,R.drawable.r36,
            R.drawable.r37,R.drawable.r38,R.drawable.r39,R.drawable.r40,R.drawable.r41,R.drawable.r42,
            R.drawable.r43,R.drawable.r44,R.drawable.r45,R.drawable.r46,R.drawable.r47,R.drawable.r48,
            R.drawable.r49,R.drawable.r50,R.drawable.r51,R.drawable.r52,R.drawable.r53,R.drawable.r54,
            R.drawable.r55,R.drawable.r56,R.drawable.r57,R.drawable.r58,R.drawable.r59,R.drawable.r60,
            R.drawable.r61,R.drawable.r62,R.drawable.r63,R.drawable.r64,R.drawable.r65,R.drawable.r66,
            R.drawable.r67,R.drawable.r68,R.drawable.r69,R.drawable.r70,R.drawable.r71,R.drawable.r72,
            R.drawable.r73,R.drawable.r74,R.drawable.r75,R.drawable.r76,R.drawable.r77,R.drawable.r78,
            R.drawable.r79,R.drawable.r80,R.drawable.r81,R.drawable.r82,R.drawable.r83,R.drawable.r84,
            R.drawable.r85,R.drawable.r86,R.drawable.r87,R.drawable.r88,R.drawable.r89,R.drawable.r90,
            R.drawable.r91,R.drawable.r92,R.drawable.r93,R.drawable.r94,R.drawable.r95,R.drawable.r96,
            R.drawable.r97,R.drawable.r98,R.drawable.r99,R.drawable.r100,

            R.drawable.r101,R.drawable.r102,R.drawable.r103,R.drawable.r104,R.drawable.r105,R.drawable.r106,
            R.drawable.r107,R.drawable.r108,R.drawable.r109,R.drawable.r110,R.drawable.r111,R.drawable.r112,
            R.drawable.r113,R.drawable.r114,R.drawable.r115,R.drawable.r116,R.drawable.r117,R.drawable.r118,
            R.drawable.r119,R.drawable.r120,R.drawable.r121,R.drawable.r122,R.drawable.r123,R.drawable.r124,
            R.drawable.r125,R.drawable.r126,R.drawable.r127,R.drawable.r128,R.drawable.r129,R.drawable.r130,
            R.drawable.r131,R.drawable.r132,R.drawable.r133,R.drawable.r134,R.drawable.r135,R.drawable.r136,
            R.drawable.r137,R.drawable.r138,R.drawable.r139,R.drawable.r140,R.drawable.r141,R.drawable.r142,
            R.drawable.r143,R.drawable.r144,R.drawable.r145,R.drawable.r146,R.drawable.r147,R.drawable.r148,
            R.drawable.r149,R.drawable.r150,R.drawable.r151,R.drawable.r152,R.drawable.r153,R.drawable.r154,
            R.drawable.r155,R.drawable.r156,R.drawable.r157,R.drawable.r158,R.drawable.r159,R.drawable.r160,
            R.drawable.r161,R.drawable.r162,R.drawable.r163,R.drawable.r164,R.drawable.r165,R.drawable.r166,
            R.drawable.r167,R.drawable.r168,R.drawable.r169,R.drawable.r170,R.drawable.r171,R.drawable.r172,
            R.drawable.r173,R.drawable.r174,R.drawable.r175,R.drawable.r176,R.drawable.r177,R.drawable.r178,
            R.drawable.r179,R.drawable.r180,R.drawable.r181,R.drawable.r182,R.drawable.r183,R.drawable.r184,
            R.drawable.r185,R.drawable.r186,R.drawable.r187,R.drawable.r188,R.drawable.r189,R.drawable.r190,
            R.drawable.r191,R.drawable.r192,R.drawable.r193,R.drawable.r194,R.drawable.r195,R.drawable.r196,
            R.drawable.r197,R.drawable.r198,R.drawable.r199,R.drawable.r200,
            R.drawable.r201,R.drawable.r202,R.drawable.r203,R.drawable.r204,
            R.drawable.r205,R.drawable.r206,R.drawable.r207,R.drawable.r208,R.drawable.r209



    };
    CustomAdapter customAdapter;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recipes=getResources().getStringArray(R.array.recipe_names);

        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        RecyclerView.LayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        customAdapter=new CustomAdapter(this,recipes,images);
        recyclerView.setAdapter(customAdapter);
        
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0754C239B1E2E19421FDE46BCEFB8855").build();
        mAdView.loadAd(adRequest);


    }




    @Override
    protected void onResume() {
        super.onResume();
        customAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_moreapps) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=MRA17"));
            startActivity(browserIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
