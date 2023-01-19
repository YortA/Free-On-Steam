package com.fos.external.gamestats.dto;

import java.util.Objects;

public class GameStatsDTO {
	private String gameId;
	private String gameName;
	// private Date dateRetrieved;
	
	
	public String getGameId() {
		return gameId;
	}
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
		GameStatsDTO other = (GameStatsDTO) obj;
		return Objects.equals(gameId, other.gameId) && Objects.equals(gameName, other.gameName);
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
