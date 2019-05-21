package com.example.invorun03;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView welcome, gateway;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        NavigationView nav = findViewById(R.id.nav_view);
        View header = nav.getHeaderView(0);
        welcome = header.findViewById(R.id.welcome);
        gateway = header.findViewById(R.id.gateway);

        if (str == null){
            gateway.setVisibility(View.GONE);
            welcome.setVisibility(View.GONE);
        }
        else {
            welcome.setText("Welcome  " + str);
            gateway.setVisibility(View.VISIBLE);
            welcome.setVisibility(View.VISIBLE);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailintent= new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "invo.feedback@gmail.com", null));
                emailintent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailintent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailintent, "Send Email..."));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void onClick (View v)
    {
        Intent intent = new Intent(getApplicationContext(), PageTwo.class);

        switch(v.getId())
        {

            //Latest

            case R.id.late2:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/the-fourth-vice-chancellor-of-daystar-university-installed/");
                startActivity(intent);
                break;

            case R.id.late3:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/vice-chancellor-meets-stakeholders-of-athi-river-road/");
                startActivity(intent);
                break;

            case R.id.late4:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/students-let-out-their-hurts-during-the-nairobi-campus-healing-forum/");
                startActivity(intent);
                break;

            case R.id.late5:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/prof-james-kombo-honoured-for-long-service/");
                startActivity(intent);
                break;

            case R.id.late6:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/students-launch-my-portal-app/");
                startActivity(intent);
                break;

            case R.id.late7:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/economics-school-hosts-crypto-currency-talk/");
                startActivity(intent);
                break;

            case R.id.late8:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/k24-covers-international-womens-day-live-from-daystar-university/");
                startActivity(intent);
                break;

            case R.id.late9:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/daystar-falcons-fetes-exemplary-characters/");
                startActivity(intent);
                break;

            case R.id.late10:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/library-updates-20/");
                startActivity(intent);
                break;



                //ACADEMICS

            case R.id.academic1:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/students-let-out-their-hurts-during-the-nairobi-campus-healing-forum/");
                startActivity(intent);
                break;

            case R.id.academic2:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/ps-irungu-nyakera-speaks-to-mba-students/");
                startActivity(intent);
                break;

            case R.id.academic3:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/economics-school-hosts-crypto-currency-talk/");
                startActivity(intent);
                break;

            case R.id.academic4:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/02/dlpdi-launches-nderu-ex-candidates-programme/");
                startActivity(intent);
                break;

            case R.id.academic5:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/02/calvin-college-visits-daystar-university/");
                startActivity(intent);
                break;

            case R.id.academic6:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/01/konrad-adenauer-foundation-donates-books-to-school-of-law/");
                startActivity(intent);
                break;

            case R.id.academic7:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/impact-africa-network/");
                startActivity(intent);
                break;


            //Jamvi

            case R.id.jamvi2:
                intent.putExtra("url","http://www.news.invonews.com/2019/03/uzinduzi-wa-samsung-galaxy-s10/");
                startActivity(intent);
                break;

            case R.id.jamvi3:
                intent.putExtra("url","http://www.news.invonews.com/2018/07/sherehe-ya-kupokea-shahada/");
                startActivity(intent);
                break;

            case R.id.jamvi4:
                intent.putExtra("url","http://www.news.invonews.com/2018/06/jamaa-achizi-baada-ya-kukosa-haki-kwa-mwanawe-aliyenajisiwa/");
                startActivity(intent);
                break;

            case R.id.jamvi5:
                intent.putExtra("url","http://www.news.invonews.com/2018/03/shaka-wa-mawaridi/");
                startActivity(intent);
                break;

            case R.id.jamvi6:
                intent.putExtra("url","http://www.news.invonews.com/2018/03/shaka-wa-mawaridi-2/");
                startActivity(intent);
                break;

            case R.id.jamvi7:
                intent.putExtra("url","http://www.news.invonews.com/2018/07/uteketezaji-wa-shule-za-sekondari/");
                startActivity(intent);
                break;


                //Campus News

            case R.id.camp2:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/students-launch-my-portal-app/");
                startActivity(intent);
                break;

            case R.id.camp3:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/mentorship-induction-program/");
                startActivity(intent);
                break;

            case R.id.camp4:
                intent.putExtra("url","http://www.news.invonews.com/2019/03/dcf-nominees-announced-as-election-date-approaches/");
                startActivity(intent);
                break;

            case R.id.camp5:
                intent.putExtra("url","http://www.news.invonews.com/2019/02/former-kenyatta-university-vice-chancellor-among-new-daystar-council-members/");
                startActivity(intent);
                break;

            case R.id.camp6:
                intent.putExtra("url","http://www.news.invonews.com/2019/02/former-kenyatta-university-vice-chancellor-among-new-daystar-council-members/");
                startActivity(intent);
                break;

            case R.id.camp7:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/01/daystar-to-roll-out-new-generation-student-id-cards/");
                startActivity(intent);
                break;

            case R.id.camp8:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/02/international-students-tour-nairobi-city/");
                startActivity(intent);
                break;

            case R.id.camp9:
                intent.putExtra("url","http://www.news.invonews.com/2019/02/jomo-gatundu-resigns-as-daystar-university-dvc-finance/");
                startActivity(intent);
                break;

            case R.id.camp10:
                intent.putExtra("url","http://www.news.invonews.com/2019/01/daystar-university-founders-recovering-following-road-accident/");
                startActivity(intent);
                break;




            //International News
            case R.id.int2:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/k24-covers-international-womens-day-live-from-daystar-university/");
                startActivity(intent);
                break;

            case R.id.int3:
                intent.putExtra("url","http://www.news.invonews.com/2018/01/dont-think-the-donald-is-the-first-to-put-us-down-weve-heard-this-talk-before/");
                startActivity(intent);
                break;

            case R.id.int4:
                intent.putExtra("url","http://www.news.invonews.com/2019/02/tensions-high-in-venezuela-as-fears-of-a-civil-war-erupt/");
                startActivity(intent);
                break;

            case R.id.int5:
                intent.putExtra("url","http://www.news.invonews.com/2019/02/the-2019-oscars-mark-a-step-from-oscarssowhite/");
                startActivity(intent);
                break;

            case R.id.int6:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/02/international-students-tour-nairobi-city/");
                startActivity(intent);
                break;

                //Kenyan News

            case R.id.kenya2:
                intent.putExtra("url","http://www.news.invonews.com/2019/04/filing-returns/");
                startActivity(intent);
                break;

            case R.id.kenya3:
                intent.putExtra("url","http://www.news.invonews.com/2019/01/overspending-an-unexpected-grace/");
                startActivity(intent);
                break;

            case R.id.kenya4:
                intent.putExtra("url","http://www.news.invonews.com/2018/01/there-is-no-quick-fix-road-safety-policy-in-kenya-2/");
                startActivity(intent);
                break;

            case R.id.kenya5:
                intent.putExtra("url","http://www.news.invonews.com/2018/01/kenyan-short-film-watu-wote-gets-nomination-at-the-90th-oscar-academy-awards/");
                startActivity(intent);
                break;

            case R.id.kenya6:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/k24-covers-international-womens-day-live-from-daystar-university/");
                startActivity(intent);
                break;

                //Sports

            case R.id.sports2:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/daystar-falcons-fetes-exemplary-characters/");
                startActivity(intent);
                break;

            case R.id.sports3:
                intent.putExtra("url","http://www.news.invonews.com/2019/01/the-daystar-soccer-league-specifics-of-how-it-came-to-be/");
                startActivity(intent);
                break;

            case R.id.sports4:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/02/daystar-falcons-beat-cooperative-university-197/");
                startActivity(intent);
                break;

            case R.id.sports5:
                intent.putExtra("url","http://www.news.invonews.com/2019/02/pole-dancing-for-fitness/");
                startActivity(intent);
                break;



            //Souvenir

            case R.id.souv2:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/chapel-diary-27/");
                startActivity(intent);
                break;
            case R.id.souv3:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/04/chapel-diary-26/");
                startActivity(intent);
                break;
            case R.id.souv4:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/02/chapel-diary-25/");
                startActivity(intent);
                break;
            case R.id.souv5:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/02/chapel-diary-24/");
                startActivity(intent);
                break;
            case R.id.souv6:
                intent.putExtra("url","http://daystar.ac.ke/blog/2019/01/chapel-diary-22/");
                startActivity(intent);
                break;

                //Features

            case R.id.features2:
                intent.putExtra("url","http://www.news.invonews.com/2019/01/online-feature-lukenya-pillars-of-transformation-is-the-place-to-be/");
                startActivity(intent);
                break;

            case R.id.features3:
                intent.putExtra("url","http://www.news.invonews.com/2019/04/filing-returns/");
                startActivity(intent);
                break;

            case R.id.features4:
                intent.putExtra("url","http://www.news.invonews.com/2019/03/entertainment-profile-dove-slimme/");
                startActivity(intent);
                break;

            case R.id.features5:
                intent.putExtra("url","http://www.news.invonews.com/2019/03/game-review-metro-exodus/");
                startActivity(intent);
                break;

            case R.id.features6:
                intent.putExtra("url","http://www.news.invonews.com/2019/02/hurricane-maria-the-aftermath-and-road-to-recovery/");
                startActivity(intent);
                break;

            case R.id.features7:
                intent.putExtra("url","http://www.news.invonews.com/2019/01/overspending-an-unexpected-grace/");
                startActivity(intent);
                break;

            case R.id.features8:
                intent.putExtra("url","http://www.news.invonews.com/2019/02/female-artists-and-rap-music-win-big-at-the-2019-grammy-awards/");
                startActivity(intent);
                break;


        }
    }
// Double press back to exit app
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplication(), Contacts.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager=getSupportFragmentManager();


        if (id == R.id.nav_first_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FirstFragment()).commit();
        }
        else if (id == R.id.nav_second_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new SecondFragment()).commit();
        }
        else if (id == R.id.nav_third_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ThirdFragment()).commit();
        }
        else if (id == R.id.nav_fourth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FourthFragment()).commit();
        }
        else if (id == R.id.nav_fifth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FifthFragment()).commit();
        }
        else if (id == R.id.nav_sixth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new SixthFragment()).commit();
        }
        else if (id == R.id.nav_seventh_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new SeventhFragment()).commit();
        }
        else if (id == R.id.nav_jamvi_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Jamvi()).commit();
        }
        else if (id == R.id.nav_share) {
            Intent shareIntent;
            String shareBody = "Nice App try it  " + "http://daystar.ac.ke/blog/2019/04/impact-africa-network/";
            shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My App");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        }
        else if (id == R.id.nav_login) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}