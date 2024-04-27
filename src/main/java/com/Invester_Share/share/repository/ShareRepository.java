package com.Invester_Share.share.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Invester_Share.share.entity.Share;



	public interface ShareRepository extends JpaRepository<Share, Long> {
	    List<Share> findAllByshareId(long shareId);
}
