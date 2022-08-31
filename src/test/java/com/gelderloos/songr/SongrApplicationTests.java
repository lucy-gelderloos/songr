package com.gelderloos.songr;

import com.gelderloos.songr.models.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test void testCreateAlbum() {
		Album testAlbum = new Album("How It Ends", "DeVotchKa",14,3000,"https://upload.wikimedia.org/wikipedia/en/6/6c/DeVotchKa_-_How_it_Ends.jpg");

		assertEquals("How It Ends",testAlbum.getTitle());
	}

	@Test void testGetNSet() {
		Album testAlbum = new Album("How It Ends", "DeVotchKa",14,3000,"https://upload.wikimedia.org/wikipedia/en/6/6c/DeVotchKa_-_How_it_Ends.jpg");

		assertEquals("DeVotchKa",testAlbum.getArtist());

		testAlbum.setArtist("Devotchka");
		assertEquals("Devotchka",testAlbum.getArtist());
	}

}
