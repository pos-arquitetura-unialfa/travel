package br.com.travelagency.travel.enums.converter;

import br.com.travelagency.travel.enums.ServiceStatus;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
public class ServiceStatusConverter implements AttributeConverter<ServiceStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ServiceStatus serviceStatus) {
        return serviceStatus.getCode();
    }

    @Override
    public ServiceStatus convertToEntityAttribute(Integer code) {
        return ServiceStatus.getByCode(code);
    }
}
