
package com.rapido.auth_service.partition;

import org.springframework.stereotype.Service;

@Service
public class PartitionStrategyService {

    public int getPartition(String rideId, int totalPartitions) {

        return Math.abs(rideId.hashCode()) % totalPartitions;
    }
}
