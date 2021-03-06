package internetshop.service.impl;

import internetshop.dao.BucketDao;
import internetshop.dao.ItemDao;
import internetshop.lib.Inject;
import internetshop.lib.Service;
import internetshop.model.Bucket;
import internetshop.model.Item;
import internetshop.service.BucketService;

import java.util.List;

@Service
public class BucketServiceImpl implements BucketService {
    @Inject
    private static BucketDao bucketDao;
    @Inject
    private static ItemDao itemDao;

    @Override
    public Bucket add(Bucket bucket) {
        return bucketDao.add(bucket);
    }

    @Override
    public Bucket get(Long id) {
        return bucketDao.get(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketDao.update(bucket);
    }

    @Override
    public void delete(Long id) {
        bucketDao.delete(id);
    }

    @Override
    public Bucket addItem(Bucket bucket, Item item) {
        Item retrievedItem = itemDao.get(item.getId());
        bucket.getItems().add(retrievedItem);
        return bucketDao.update(bucket);
    }

    @Override
    public Bucket clear(Bucket bucket) {
        bucket.getItems().clear();
        return bucket;
    }

    @Override
    public List<Item> getAllItems(Bucket bucket) {
        return bucket.getItems();
    }

    @Override
    public void deleteItem(Long bucketId, Item item) {
        Bucket bucket = bucketDao.get(bucketId);
        bucket.getItems().remove(item);
    }
}
