package com.tms.util;

import java.util.Comparator;
import org.apache.commons.lang3.builder.CompareToBuilder;
import com.tms.model.participantDO;

public class ParticipantComparator implements Comparator<participantDO> {

	@Override
	public int compare(participantDO o1, participantDO o2) {
		return new CompareToBuilder()
                .append(o1.getHeight(), o2.getHeight())
                .append(o1.getWeight(), o2.getWeight()).toComparison();
	}

}
