package ca.mcgill.ecse321.android_has_v3;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import ca.mcgill.ecse321.android_has_v3.albums.AddAlbumActivity;
import ca.mcgill.ecse321.android_has_v3.albums.AlbumNavFragment;
import ca.mcgill.ecse321.android_has_v3.artists.AddArtistActivity;
import ca.mcgill.ecse321.android_has_v3.artists.ArtistNavFragment;
import ca.mcgill.ecse321.android_has_v3.playlists.AddPlaylistActivity;
import ca.mcgill.ecse321.android_has_v3.playlists.PlaylistNavFragment;
import ca.mcgill.ecse321.android_has_v3.songs.AddSongActivity;
import ca.mcgill.ecse321.android_has_v3.songs.SongNavFragment;

public class MyMusicActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //autogenerated code
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Sets the song view as the default on startup
        if(HASAndroidApplication.getCurrentMenu() == null)
            HASAndroidApplication.setCurrentMenu(navigationView.getMenu().getItem(2));
        HASAndroidApplication.getCurrentMenu().setChecked(true);
        onNavigationItemSelected(HASAndroidApplication.getCurrentMenu());
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        HASAndroidApplication.setCurrentMenu(item);

        int id = item.getItemId();
        Fragment fragment = null;

        switch (id){
            case R.id.nav_artists:
                fragment = new ArtistNavFragment();
                setTitle("Artists");
                break;

            case R.id.nav_albums:
                fragment = new AlbumNavFragment();
                setTitle("Albums");
                break;

            case R.id.nav_songs:
                fragment = new SongNavFragment();
                setTitle("Songs");
                break;

            case R.id.nav_playlists:
                fragment = new PlaylistNavFragment();
                setTitle("Playlists");
                break;

            case R.id.nav_rooms:

                setTitle("Rooms");
                break;

            case R.id.nav_room_groups:

                setTitle("Room Groups ");
                break;
        }

        //sets the new fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_container, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addArtist(View v) {
        Intent intent = new Intent(this, AddArtistActivity.class);
        startActivity(intent);
    }

    public void addAlbum(View v) {
        Intent intent = new Intent(this, AddAlbumActivity.class);
        startActivity(intent);
    }

    public void addSong(View v) {
        Intent intent = new Intent(this, AddSongActivity.class);
        startActivity(intent);
    }

    public void addPlaylist(View v) {
        Intent intent = new Intent(this, AddPlaylistActivity.class);
        startActivity(intent);
    }

    public void sortByAlbum(View v) {
        //TODO implement sorting
    }

    public void sortByArtist(View v) {
        //TODO implement sorting
    }
}
