package com.quangminh.optimisticforceincrement.service;

import com.quangminh.optimisticforceincrement.entity.Chapter;
import com.quangminh.optimisticforceincrement.entity.Modification;
import com.quangminh.optimisticforceincrement.repository.ChapterRepository;
import com.quangminh.optimisticforceincrement.repository.ModificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.logging.Logger;

@Service
public class BookstoreService {
    private static final Logger log = Logger.getLogger(BookstoreService.class.getName());
    private final ChapterRepository chapterRepository;
    private final ModificationRepository modificationRepository;
    private final TransactionTemplate template;

    public BookstoreService(ChapterRepository chapterRepository, ModificationRepository modificationRepository, TransactionTemplate transactionTemplate) {
        this.chapterRepository = chapterRepository;
        this.modificationRepository = modificationRepository;
        this.template = transactionTemplate;
    }
    // running this application will
    // throw org.springframework.orm.ObjectOptimisticLockingFailureException
    public void editChapter() {
        template.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {

                log.info("Starting first transaction ...");

                Chapter chapter = chapterRepository.findById(1L).orElseThrow();

                Modification modification = new Modification();
                modification.setDescription("Rewording first paragraph");
                modification.setModification("Reword: ... Added: ...");
                modification.setChapter(chapter);

                template.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus status) {

                        log.info("Starting second transaction ...");

                        Chapter chapter = chapterRepository.findById(1L).orElseThrow();

                        Modification modification = new Modification();
                        modification.setDescription("Formatting second paragraph");
                        modification.setModification("Format ...");
                        modification.setChapter(chapter);

                        modificationRepository.save(modification);

                        log.info("Commit second transaction ...");
                    }
                });

                log.info("Resuming first transaction ...");

                modificationRepository.save(modification);

                log.info("Commit first transaction ...");
            }
        });

        log.info("Done!");
    }
}
