package com.fos.external.gamestats.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
 * game_id = string
 * game_name = string
 * date_retrieved = date
 */
@Entity
public class GameStats {
	
	@Id
	@NotNull
	@Column(name = "game_id", nullable = false, length = 30)
	private String gameId;
	@NotNull
	@Column(name = "game_name", nullable = false, length = 1000)
	private String gameName;
	// @Column(name = "date_retrieved", nullable = false)
	// private Date dateRetrieved;
	
	@Override
	public int hashCode() {
		return Objects.hash(gameId, gameName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameStats other = (GameStats) obj;
		return Objects.equals(gameId, other.gameId) && Objects.equals(gameName, other.gameName);
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
}
