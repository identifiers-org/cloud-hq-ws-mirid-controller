package org.identifiers.cloud.hq.ws.miridcontroller.models;

import lombok.extern.slf4j.Slf4j;
import org.identifiers.cloud.hq.ws.miridcontroller.data.models.ActiveMirId;
import org.identifiers.cloud.hq.ws.miridcontroller.data.models.ReturnedMirId;
import org.identifiers.cloud.hq.ws.miridcontroller.data.repositories.ActiveMirIdRepository;
import org.identifiers.cloud.hq.ws.miridcontroller.data.repositories.MirIdDeactivationLogEntryRepository;
import org.identifiers.cloud.hq.ws.miridcontroller.data.repositories.ReturnedMirIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Project: mirid-controller
 * Package: org.identifiers.cloud.hq.ws.miridcontroller.models
 * Timestamp: 2019-02-26 12:47
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@Component
@Slf4j
public class DbBackedMirIdManagementStrategy implements MirIdManagementStrategy {

    @Autowired
    private ActiveMirIdRepository activeMirIdRepository;
    @Autowired
    private MirIdDeactivationLogEntryRepository mirIdDeactivationLogEntryRepository;
    @Autowired
    private ReturnedMirIdRepository returnedMirIdRepository;

    @Transactional
    @Override
    public long mintId() throws MirIdManagementStrategyException {
        // TODO
    }

    @Transactional
    @Override
    public void keepAlive(long id) throws MirIdManagementStrategyException {
        // TODO
    }

    @Transactional
    @Override
    public void loadId(long id) throws MirIdManagementStrategyException {
        // TODO
    }

    @Transactional
    @Override
    public void returnId(long id) throws MirIdManagementStrategyException {
        // TODO
    }
}
