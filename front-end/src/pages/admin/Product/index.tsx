import React, { useEffect } from "react";
import "./Product.styles.scss";
import { connect, ConnectedProps } from "react-redux";
import UiBadge from "../../../components/UiBadge";
import UiTable from "../../../components/UiTable";
import { getAllProduct } from "../../../reduxs/thunks/product.thunks";

const latestOrders = {
    header: [
        "ID",
        "Name",
        "Username",
        "Email",
        "Role",
        "Status"
    ],
}

// const orderStatus: any = {
//     "shipping": "primary",
//     "pending": "warning",
//     "paid": "success",
//     "refund": "danger"
// }

const orderStatus: any = {
    "-1": "primary",
    "0": "warning",
    "1": "success",
    "3": "danger"
}
const orderActive: any = {
    "0": "Disable",
    "1": "Active",
}

const renderOrderHead = (item: any, index: any) => (
    <th key={index}>{item}</th>
)

const renderOrderBody = (item: any, index: any) => (
    <tr key={index}>
        <td>{item.id}</td>
        <td>{item.firstName + ' ' + item.lastName}</td>
        <td>{item.username}</td>
        <td>{item.email}</td>
        <td>{item.role}</td>
        <td>
            <UiBadge type={orderStatus[item.activeFlag]} content={orderActive[item.activeFlag]} />
        </td>
    </tr>
)



const mapStateToProps = (state: AppState) => ({
    products: state.product.products,
    isFetching: state.product.isFetching
})

const mapDispatchToProps = { getAllProduct }

const connector = connect(mapStateToProps, mapDispatchToProps);

interface Props extends ConnectedProps<typeof connector> { }

const ProductAdmin: React.FC<Props> = (props: Props) => {
    const { getAllProduct, products } = props;

    useEffect(() => {
        getAllProduct();
    }, [getAllProduct])

    return (
        <div className="card">
            <div className="card__header">
                <h3>Product Management</h3>
            </div>
            <div className="card__body">
                <UiTable
                    headData={latestOrders.header}
                    renderHead={(item: any, index: any) => renderOrderHead(item, index)}
                    bodyData={products}
                    renderBody={(item: any, index: any) => renderOrderBody(item, index)}
                />
            </div>
            {/* <div className="card__footer">
            <Link to='/'>view all</Link>
        </div> */}
        </div>
    )
};

export default connector(ProductAdmin);