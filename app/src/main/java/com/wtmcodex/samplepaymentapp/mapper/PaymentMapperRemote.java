package com.wtmcodex.samplepaymentapp.mapper;

import com.wtmcodex.samplepaymentapp.core.data.model.ApplicableNetwork;
import com.wtmcodex.samplepaymentapp.core.data.model.PaymentModel;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentMapperRemote implements BaseMapper<List<ApplicableNetwork>, List<PaymentModel>> {

    @Override
    public List<PaymentModel> transformToDomain(List<ApplicableNetwork> type) {
        return type.stream().map(applicableNetwork -> {
            String logoUrl = null;
            if (applicableNetwork.getLinks() != null && applicableNetwork.getLinks().containsKey("logo")) {
                logoUrl = applicableNetwork.getLinks().get("logo").toString();
            }
            return new PaymentModel(applicableNetwork.getLabel(), applicableNetwork.getCode(), applicableNetwork.getMethod(), logoUrl);
        }).collect(Collectors.toList());
    }

    @Override
    public List<ApplicableNetwork> transformToDto(List<PaymentModel> type) {
        return null;
    }
}
