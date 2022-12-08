package couponsopsjava;

import java.util.*;
import java.util.stream.Collectors;


public class CouponOperation implements ICouponOperation {
    private HashMap<Website, List<Coupon>> websiteCouponMap;
    private HashMap<String, Coupon> couponMap;

    public CouponOperation() {
        this.websiteCouponMap = new HashMap<>();
        this.couponMap = new HashMap<>();
    }

    public void registerSite(Website w) {
        if (exist(w)) {
            throw new IllegalArgumentException();
        }

        websiteCouponMap.put(w, new ArrayList<>());
    }

    public void addCoupon(Website w, Coupon c) {
        if (!exist(w) || exist(c)) {
            throw new IllegalArgumentException();
        }

        websiteCouponMap.get(w).add(c);
        couponMap.put(c.code, c);
    }

    public Website removeWebsite(String domain) {
        Website websiteRemoved = null;

        for (Website website : websiteCouponMap.keySet()) {
            if (website.domain.equals(domain)) {
                websiteRemoved = website;
                break;
            }
        }

        if (websiteRemoved == null) {
            throw new IllegalArgumentException();
        }

        this.websiteCouponMap.get(websiteRemoved).clear();
        this.websiteCouponMap.remove(websiteRemoved);

        return websiteRemoved;
    }

    public Coupon removeCoupon(String code) {
        Coupon couponRemoved = null;

        for (List<Coupon> listCoupons : websiteCouponMap.values()) {
            for (Coupon coupon : listCoupons) {
                if (coupon.code.equals(code)) {
                    couponRemoved = coupon;
                    listCoupons.remove(coupon);
                }
            }
        }

        if (couponRemoved == null) {
            throw new IllegalArgumentException();
        }

        couponMap.remove(couponRemoved.code);

        return couponRemoved;
    }

    public boolean exist(Website w) {
        return websiteCouponMap.containsKey(w);
    }

    public boolean exist(Coupon c) {
        return couponMap.containsKey(c.code);
    }

    public Collection<Website> getSites() {
        return this.websiteCouponMap.keySet();
    }

    public Collection<Coupon> getCouponsForWebsite(Website w) {
        if (!exist(w)) {
            throw new IllegalArgumentException();
        }

        return this.websiteCouponMap.get(w);
    }

    public void useCoupon(Website w, Coupon c) {
        if (!exist(w) || !exist(c)) {
            throw new IllegalArgumentException();
        }

        boolean removeCouponNotExist = true;

        List<Coupon> coupons = this.websiteCouponMap.get(w);

        for (Coupon coupon : coupons) {
            if (coupon.code.equals(c.code)) {
                removeCouponNotExist = false;
                coupons.remove(coupon);
                break;
            }
        }

        if (removeCouponNotExist) {
            throw new IllegalArgumentException();
        }
    }

    public Collection<Coupon> getCouponsOrderedByValidityDescAndDiscountPercentageDesc() {
        return this.couponMap
                .values()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.validity, f.validity);

                    if (result == 0) {
                        result = Integer.compare(s.discountPercentage, f.discountPercentage);
                    }

                    return result;
                })
                .collect(Collectors.toList());
    }

    public Collection<Website> getWebsitesOrderedByUserCountAndCouponsCountDesc() {
        return this.websiteCouponMap
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(f.getKey().usersCount, s.getKey().usersCount);

                    if (result == 0) {
                        result = Integer.compare(s.getValue().size(), f.getValue().size());
                    }

                    return result;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
