package com.fos.external.gamestats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fos.external.gamestats.entity.GameStats;

public interface GameStatsRepo extends JpaRepository<GameStats, String> {

}
