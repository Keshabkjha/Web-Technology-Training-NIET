#include <bits/stdc++.h>
using namespace std;

// Custom point struct with equality operator
struct Pt {
    int r, c;
    bool operator==(const Pt &o) const noexcept {
        return r == o.r && c == o.c;
    }
};

// Hash functor for Pt
struct PtHash {
    size_t operator()(const Pt &p) const noexcept {
        return (uint64_t(uint32_t(p.r)) << 32) ^ uint32_t(p.c);
    }
};

// Composite key struct for segment lookup
struct SegKey {
    int r, c, id;
    bool operator==(const SegKey &o) const noexcept {
        return r == o.r && c == o.c && id == o.id;
    }
};

// Hash functor for SegKey
struct SegHash {
    size_t operator()(const SegKey &k) const noexcept {
        uint64_t h = uint64_t(k.r);
        h = (h << 21) ^ uint64_t(k.c);
        h = (h << 21) ^ uint64_t(k.id);
        return size_t(h);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<long long> raw;
    long long val;
    while (cin >> val) raw.push_back(val);
    if (raw.empty()) return 0;

    int pos = 0;
    int segCount = (int)raw[pos++];
    vector<array<int, 4>> seg(segCount);
    for (int i = 0; i < segCount; ++i) {
        seg[i][0] = (int)raw[pos++];
        seg[i][1] = (int)raw[pos++];
        seg[i][2] = (int)raw[pos++];
        seg[i][3] = (int)raw[pos++];
    }

    int sx = (int)raw[pos++];
    int sy = (int)raw[pos++];
    int energy = (int)raw[pos++];

    unordered_map<Pt, vector<int>, PtHash> touch;
    unordered_map<SegKey, pair<int, int>, SegHash> nextPos;

    // Build relationships
    for (int id = 0; id < segCount; ++id) {
        int x1 = seg[id][0], y1 = seg[id][1], x2 = seg[id][2], y2 = seg[id][3];
        int dx = (x2 > x1) ? 1 : -1;
        int len = abs(x2 - x1);

        if (y2 < y1) { // downward slope
            for (int k = 0; k < len; ++k) {
                int x = x1 + dx * k;
                int y = y1 - k;
                touch[{x, y}].push_back(id);
                nextPos[{x, y, id}] = {x + dx, y - 1};
            }
            touch[{x2, y2}].push_back(id);
        } else { // upward slope
            for (int k = 0; k < len; ++k) {
                int x = x2 - dx * k;
                int y = y2 - k;
                touch[{x, y}].push_back(id);
                nextPos[{x, y, id}] = {x - dx, y - 1};
            }
            touch[{x1, y1}].push_back(id);
        }
    }

    // Drop vertically until something is hit or reach y=0
    auto dropDown = [&](int x, int y) -> pair<int, int> {
        for (int yy = y - 1; yy >= 0; --yy) {
            if (touch.find({x, yy}) != touch.end())
                return {x, yy};
        }
        return {x, 0};
    };

    int x = sx, y = sy;
    if (touch.find({x, y}) == touch.end()) {
        auto p = dropDown(x, y);
        x = p.first; y = p.second;
    }

    // Simulate motion
    while (true) {
        if (y == 0) break;

        auto it = touch.find({x, y});
        if (it == touch.end()) {
            auto p = dropDown(x, y);
            x = p.first; y = p.second;
            continue;
        }

        auto &ids = it->second;
        if (ids.size() == 1) {
            int id = ids[0];
            auto jt = nextPos.find({x, y, id});
            if (jt == nextPos.end()) {
                auto p = dropDown(x, y);
                x = p.first; y = p.second;
                continue;
            }
            if (energy == 0) break;
            --energy;
            x = jt->second.first;
            y = jt->second.second;
        } else {
            long long c = 1LL * x * y;
            vector<pair<int, pair<int, int>>> dn;
            dn.reserve(ids.size());

            for (int id : ids) {
                auto jt = nextPos.find({x, y, id});
                if (jt != nextPos.end()) dn.push_back({id, jt->second});
            }

            if ((long long)energy <= c) {
                if (dn.empty()) {
                    auto p = dropDown(x, y);
                    x = p.first; y = p.second;
                    continue;
                }
                break;
            }

            energy -= (int)c;
            if (dn.empty()) {
                auto p = dropDown(x, y);
                x = p.first; y = p.second;
                continue;
            }

            int bestX = 0, bestY = -1;
            for (auto &qq : dn) {
                int xx = qq.second.first;
                int yy = qq.second.second;
                if (yy > bestY) {
                    bestY = yy;
                    bestX = xx;
                }
            }
            if (energy == 0) break;
            --energy;
            x = bestX; y = bestY;
        }
    }

    cout << x << " " << y;
    return 0;
}
